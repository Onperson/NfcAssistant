/*
 * Copyright 2013 Gerhard Klostermeier
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.power.nfc.assistant.activitys;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import java.nio.ByteBuffer;

import com.power.nfc.assistant.abs.NfcAssistantApplication;
import com.power.nfc.assistant.R;

/**
 * Display value blocks in a way a user can read easily (as integer).
 * NXP has PDFs describing what value blocks are.
 * Google something like "nxp MIFARE classic value blocks",
 * if you want to have a closer look.
 * This Activity will be shown from the {@link DumpEditor}, if the user
 * clicks the corresponding menu item.
 * @author Gerhard Klostermeier
 */
public class ValueBlocksToInt extends BasicActivity {

    public final static String EXTRA_VB =
            "com.power.nfc.assistant.Activity.VB";

    private static final String LOG_TAG =
            ValueBlocksToInt.class.getSimpleName();

    private TableLayout mLayout;

    /**
     * Get value blocks from Intent and initialize Activity to
     * displaying them. If there is no Intent with
     * {@link #EXTRA_VB}, the Activity will be exited.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_blocks_to_int);

        boolean noValueBlocks = false;
        if (getIntent().hasExtra(EXTRA_VB)) {
            mLayout = findViewById(
                    R.id.tableLayoutValueBlocksToInt);
            String[] valueBlocks = getIntent().getStringArrayExtra(EXTRA_VB);
            if (valueBlocks.length > 0) {
                for (int i = 0; i < valueBlocks.length; i=i+2) {
                    String[] sectorAndBlock = valueBlocks[i].split(", ");
                    String sectorNumber = sectorAndBlock[0].split(": ")[1];
                    String blockNumber = sectorAndBlock[1].split(": ")[1];
                    addPosInfoRow(getString(R.string.text_sector)
                            + ": " + sectorNumber + ", "
                            + getString(R.string.text_block)
                            + ": " + blockNumber);
                    addValueBlock(valueBlocks[i+1]);
                }
            } else {
                noValueBlocks = true;
            }
        } else {
            noValueBlocks = true;
        }

        if (noValueBlocks) {
            Log.d(LOG_TAG, "There was no value block in intent.");
            finish();
        }
    }

    /**
     * Add a row with position information to the layout table.
     * This row shows the user where the value block is located (sector, block).
     * @param value The position information (e.g. "Sector: 1, Block: 2").
     */
    private void addPosInfoRow(String value) {
        TextView header = new TextView(this);
        header.setText(NfcAssistantApplication.colorString(value,
                getResources().getColor(R.color.blue)),
                BufferType.SPANNABLE);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        tr.addView(header);
        mLayout.addView(tr, new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    /**
     * Add full value block information (original
     * and integer format) to the layout table (two rows).
     * @param hexValueBlock The value block as hex string (32 chars.).
     */
    private void addValueBlock(String hexValueBlock) {
        TableRow tr = new TableRow(this);
        TextView what = new TextView(this);
        TextView value = new TextView(this);

        // Original.
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        what.setText(R.string.text_vb_orig);
        value.setText(NfcAssistantApplication.colorString(hexValueBlock.substring(0, 8),
                getResources().getColor(R.color.yellow)));
        tr.addView(what);
        tr.addView(value);
        mLayout.addView(tr, new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        // Resolved to int.
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        what = new TextView(this);
        what.setText(R.string.text_vb_as_int_decoded);
        value = new TextView(this);
        byte[] asBytes = NfcAssistantApplication.hexStringToByteArray(
                hexValueBlock.substring(0, 8));
        NfcAssistantApplication.reverseByteArrayInPlace(asBytes);
        ByteBuffer bb = ByteBuffer.wrap(asBytes);
        int i = bb.getInt();
        String asInt = "" + i;
        value.setText(NfcAssistantApplication.colorString(asInt,
                getResources().getColor(R.color.light_green)));
        tr.addView(what);
        tr.addView(value);
        mLayout.addView(tr, new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
    }
}
