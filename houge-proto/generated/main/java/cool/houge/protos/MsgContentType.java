// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/protos/msg_enums.proto

package cool.houge.protos;

/**
 * <pre>
 * 消息内容
 * </pre>
 *
 * Protobuf enum {@code MsgContentType}
 */
public enum MsgContentType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 文本消息类型
   * </pre>
   *
   * <code>TEXT = 0;</code>
   */
  TEXT(0),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * 文本消息类型
   * </pre>
   *
   * <code>TEXT = 0;</code>
   */
  public static final int TEXT_VALUE = 0;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MsgContentType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static MsgContentType forNumber(int value) {
    switch (value) {
      case 0: return TEXT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MsgContentType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MsgContentType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MsgContentType>() {
          public MsgContentType findValueByNumber(int number) {
            return MsgContentType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return cool.houge.protos.MsgEnums.getDescriptor().getEnumTypes().get(1);
  }

  private static final MsgContentType[] VALUES = values();

  public static MsgContentType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MsgContentType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:MsgContentType)
}

