package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.power.nfc.assistant.DataBinderMapperImpl());
  }
}
