// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/broker.proto

package cool.houge.grpc;

/**
 * Protobuf type {@code AttachBrokerResponse}
 */
public final class AttachBrokerResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AttachBrokerResponse)
    AttachBrokerResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AttachBrokerResponse.newBuilder() to construct.
  private AttachBrokerResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AttachBrokerResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AttachBrokerResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AttachBrokerResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            cool.houge.grpc.BrokerMsg.Builder subBuilder = null;
            if (kindCase_ == 1) {
              subBuilder = ((cool.houge.grpc.BrokerMsg) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(cool.houge.grpc.BrokerMsg.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((cool.houge.grpc.BrokerMsg) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 1;
            break;
          }
          case 74: {
            cool.houge.grpc.BrokerCommand.Builder subBuilder = null;
            if (kindCase_ == 9) {
              subBuilder = ((cool.houge.grpc.BrokerCommand) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(cool.houge.grpc.BrokerCommand.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((cool.houge.grpc.BrokerCommand) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 9;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cool.houge.grpc.BrokerOuterClass.internal_static_AttachBrokerResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cool.houge.grpc.BrokerOuterClass.internal_static_AttachBrokerResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cool.houge.grpc.AttachBrokerResponse.class, cool.houge.grpc.AttachBrokerResponse.Builder.class);
  }

  private int kindCase_ = 0;
  private java.lang.Object kind_;
  public enum KindCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    MSG(1),
    COMMAND(9),
    KIND_NOT_SET(0);
    private final int value;
    private KindCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static KindCase valueOf(int value) {
      return forNumber(value);
    }

    public static KindCase forNumber(int value) {
      switch (value) {
        case 1: return MSG;
        case 9: return COMMAND;
        case 0: return KIND_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public KindCase
  getKindCase() {
    return KindCase.forNumber(
        kindCase_);
  }

  public static final int MSG_FIELD_NUMBER = 1;
  /**
   * <code>.BrokerMsg msg = 1;</code>
   * @return Whether the msg field is set.
   */
  @java.lang.Override
  public boolean hasMsg() {
    return kindCase_ == 1;
  }
  /**
   * <code>.BrokerMsg msg = 1;</code>
   * @return The msg.
   */
  @java.lang.Override
  public cool.houge.grpc.BrokerMsg getMsg() {
    if (kindCase_ == 1) {
       return (cool.houge.grpc.BrokerMsg) kind_;
    }
    return cool.houge.grpc.BrokerMsg.getDefaultInstance();
  }
  /**
   * <code>.BrokerMsg msg = 1;</code>
   */
  @java.lang.Override
  public cool.houge.grpc.BrokerMsgOrBuilder getMsgOrBuilder() {
    if (kindCase_ == 1) {
       return (cool.houge.grpc.BrokerMsg) kind_;
    }
    return cool.houge.grpc.BrokerMsg.getDefaultInstance();
  }

  public static final int COMMAND_FIELD_NUMBER = 9;
  /**
   * <code>.BrokerCommand command = 9;</code>
   * @return Whether the command field is set.
   */
  @java.lang.Override
  public boolean hasCommand() {
    return kindCase_ == 9;
  }
  /**
   * <code>.BrokerCommand command = 9;</code>
   * @return The command.
   */
  @java.lang.Override
  public cool.houge.grpc.BrokerCommand getCommand() {
    if (kindCase_ == 9) {
       return (cool.houge.grpc.BrokerCommand) kind_;
    }
    return cool.houge.grpc.BrokerCommand.getDefaultInstance();
  }
  /**
   * <code>.BrokerCommand command = 9;</code>
   */
  @java.lang.Override
  public cool.houge.grpc.BrokerCommandOrBuilder getCommandOrBuilder() {
    if (kindCase_ == 9) {
       return (cool.houge.grpc.BrokerCommand) kind_;
    }
    return cool.houge.grpc.BrokerCommand.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (kindCase_ == 1) {
      output.writeMessage(1, (cool.houge.grpc.BrokerMsg) kind_);
    }
    if (kindCase_ == 9) {
      output.writeMessage(9, (cool.houge.grpc.BrokerCommand) kind_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (kindCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (cool.houge.grpc.BrokerMsg) kind_);
    }
    if (kindCase_ == 9) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(9, (cool.houge.grpc.BrokerCommand) kind_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cool.houge.grpc.AttachBrokerResponse)) {
      return super.equals(obj);
    }
    cool.houge.grpc.AttachBrokerResponse other = (cool.houge.grpc.AttachBrokerResponse) obj;

    if (!getKindCase().equals(other.getKindCase())) return false;
    switch (kindCase_) {
      case 1:
        if (!getMsg()
            .equals(other.getMsg())) return false;
        break;
      case 9:
        if (!getCommand()
            .equals(other.getCommand())) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (kindCase_) {
      case 1:
        hash = (37 * hash) + MSG_FIELD_NUMBER;
        hash = (53 * hash) + getMsg().hashCode();
        break;
      case 9:
        hash = (37 * hash) + COMMAND_FIELD_NUMBER;
        hash = (53 * hash) + getCommand().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cool.houge.grpc.AttachBrokerResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cool.houge.grpc.AttachBrokerResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code AttachBrokerResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AttachBrokerResponse)
      cool.houge.grpc.AttachBrokerResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cool.houge.grpc.BrokerOuterClass.internal_static_AttachBrokerResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cool.houge.grpc.BrokerOuterClass.internal_static_AttachBrokerResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cool.houge.grpc.AttachBrokerResponse.class, cool.houge.grpc.AttachBrokerResponse.Builder.class);
    }

    // Construct using cool.houge.grpc.AttachBrokerResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      kindCase_ = 0;
      kind_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cool.houge.grpc.BrokerOuterClass.internal_static_AttachBrokerResponse_descriptor;
    }

    @java.lang.Override
    public cool.houge.grpc.AttachBrokerResponse getDefaultInstanceForType() {
      return cool.houge.grpc.AttachBrokerResponse.getDefaultInstance();
    }

    @java.lang.Override
    public cool.houge.grpc.AttachBrokerResponse build() {
      cool.houge.grpc.AttachBrokerResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cool.houge.grpc.AttachBrokerResponse buildPartial() {
      cool.houge.grpc.AttachBrokerResponse result = new cool.houge.grpc.AttachBrokerResponse(this);
      if (kindCase_ == 1) {
        if (msgBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = msgBuilder_.build();
        }
      }
      if (kindCase_ == 9) {
        if (commandBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = commandBuilder_.build();
        }
      }
      result.kindCase_ = kindCase_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cool.houge.grpc.AttachBrokerResponse) {
        return mergeFrom((cool.houge.grpc.AttachBrokerResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cool.houge.grpc.AttachBrokerResponse other) {
      if (other == cool.houge.grpc.AttachBrokerResponse.getDefaultInstance()) return this;
      switch (other.getKindCase()) {
        case MSG: {
          mergeMsg(other.getMsg());
          break;
        }
        case COMMAND: {
          mergeCommand(other.getCommand());
          break;
        }
        case KIND_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      cool.houge.grpc.AttachBrokerResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cool.houge.grpc.AttachBrokerResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int kindCase_ = 0;
    private java.lang.Object kind_;
    public KindCase
        getKindCase() {
      return KindCase.forNumber(
          kindCase_);
    }

    public Builder clearKind() {
      kindCase_ = 0;
      kind_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        cool.houge.grpc.BrokerMsg, cool.houge.grpc.BrokerMsg.Builder, cool.houge.grpc.BrokerMsgOrBuilder> msgBuilder_;
    /**
     * <code>.BrokerMsg msg = 1;</code>
     * @return Whether the msg field is set.
     */
    @java.lang.Override
    public boolean hasMsg() {
      return kindCase_ == 1;
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     * @return The msg.
     */
    @java.lang.Override
    public cool.houge.grpc.BrokerMsg getMsg() {
      if (msgBuilder_ == null) {
        if (kindCase_ == 1) {
          return (cool.houge.grpc.BrokerMsg) kind_;
        }
        return cool.houge.grpc.BrokerMsg.getDefaultInstance();
      } else {
        if (kindCase_ == 1) {
          return msgBuilder_.getMessage();
        }
        return cool.houge.grpc.BrokerMsg.getDefaultInstance();
      }
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    public Builder setMsg(cool.houge.grpc.BrokerMsg value) {
      if (msgBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        msgBuilder_.setMessage(value);
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    public Builder setMsg(
        cool.houge.grpc.BrokerMsg.Builder builderForValue) {
      if (msgBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        msgBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    public Builder mergeMsg(cool.houge.grpc.BrokerMsg value) {
      if (msgBuilder_ == null) {
        if (kindCase_ == 1 &&
            kind_ != cool.houge.grpc.BrokerMsg.getDefaultInstance()) {
          kind_ = cool.houge.grpc.BrokerMsg.newBuilder((cool.houge.grpc.BrokerMsg) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 1) {
          msgBuilder_.mergeFrom(value);
        }
        msgBuilder_.setMessage(value);
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    public Builder clearMsg() {
      if (msgBuilder_ == null) {
        if (kindCase_ == 1) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 1) {
          kindCase_ = 0;
          kind_ = null;
        }
        msgBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    public cool.houge.grpc.BrokerMsg.Builder getMsgBuilder() {
      return getMsgFieldBuilder().getBuilder();
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    @java.lang.Override
    public cool.houge.grpc.BrokerMsgOrBuilder getMsgOrBuilder() {
      if ((kindCase_ == 1) && (msgBuilder_ != null)) {
        return msgBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 1) {
          return (cool.houge.grpc.BrokerMsg) kind_;
        }
        return cool.houge.grpc.BrokerMsg.getDefaultInstance();
      }
    }
    /**
     * <code>.BrokerMsg msg = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cool.houge.grpc.BrokerMsg, cool.houge.grpc.BrokerMsg.Builder, cool.houge.grpc.BrokerMsgOrBuilder> 
        getMsgFieldBuilder() {
      if (msgBuilder_ == null) {
        if (!(kindCase_ == 1)) {
          kind_ = cool.houge.grpc.BrokerMsg.getDefaultInstance();
        }
        msgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cool.houge.grpc.BrokerMsg, cool.houge.grpc.BrokerMsg.Builder, cool.houge.grpc.BrokerMsgOrBuilder>(
                (cool.houge.grpc.BrokerMsg) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 1;
      onChanged();;
      return msgBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        cool.houge.grpc.BrokerCommand, cool.houge.grpc.BrokerCommand.Builder, cool.houge.grpc.BrokerCommandOrBuilder> commandBuilder_;
    /**
     * <code>.BrokerCommand command = 9;</code>
     * @return Whether the command field is set.
     */
    @java.lang.Override
    public boolean hasCommand() {
      return kindCase_ == 9;
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     * @return The command.
     */
    @java.lang.Override
    public cool.houge.grpc.BrokerCommand getCommand() {
      if (commandBuilder_ == null) {
        if (kindCase_ == 9) {
          return (cool.houge.grpc.BrokerCommand) kind_;
        }
        return cool.houge.grpc.BrokerCommand.getDefaultInstance();
      } else {
        if (kindCase_ == 9) {
          return commandBuilder_.getMessage();
        }
        return cool.houge.grpc.BrokerCommand.getDefaultInstance();
      }
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    public Builder setCommand(cool.houge.grpc.BrokerCommand value) {
      if (commandBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        commandBuilder_.setMessage(value);
      }
      kindCase_ = 9;
      return this;
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    public Builder setCommand(
        cool.houge.grpc.BrokerCommand.Builder builderForValue) {
      if (commandBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        commandBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 9;
      return this;
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    public Builder mergeCommand(cool.houge.grpc.BrokerCommand value) {
      if (commandBuilder_ == null) {
        if (kindCase_ == 9 &&
            kind_ != cool.houge.grpc.BrokerCommand.getDefaultInstance()) {
          kind_ = cool.houge.grpc.BrokerCommand.newBuilder((cool.houge.grpc.BrokerCommand) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 9) {
          commandBuilder_.mergeFrom(value);
        }
        commandBuilder_.setMessage(value);
      }
      kindCase_ = 9;
      return this;
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    public Builder clearCommand() {
      if (commandBuilder_ == null) {
        if (kindCase_ == 9) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 9) {
          kindCase_ = 0;
          kind_ = null;
        }
        commandBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    public cool.houge.grpc.BrokerCommand.Builder getCommandBuilder() {
      return getCommandFieldBuilder().getBuilder();
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    @java.lang.Override
    public cool.houge.grpc.BrokerCommandOrBuilder getCommandOrBuilder() {
      if ((kindCase_ == 9) && (commandBuilder_ != null)) {
        return commandBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 9) {
          return (cool.houge.grpc.BrokerCommand) kind_;
        }
        return cool.houge.grpc.BrokerCommand.getDefaultInstance();
      }
    }
    /**
     * <code>.BrokerCommand command = 9;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cool.houge.grpc.BrokerCommand, cool.houge.grpc.BrokerCommand.Builder, cool.houge.grpc.BrokerCommandOrBuilder> 
        getCommandFieldBuilder() {
      if (commandBuilder_ == null) {
        if (!(kindCase_ == 9)) {
          kind_ = cool.houge.grpc.BrokerCommand.getDefaultInstance();
        }
        commandBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cool.houge.grpc.BrokerCommand, cool.houge.grpc.BrokerCommand.Builder, cool.houge.grpc.BrokerCommandOrBuilder>(
                (cool.houge.grpc.BrokerCommand) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 9;
      onChanged();;
      return commandBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:AttachBrokerResponse)
  }

  // @@protoc_insertion_point(class_scope:AttachBrokerResponse)
  private static final cool.houge.grpc.AttachBrokerResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cool.houge.grpc.AttachBrokerResponse();
  }

  public static cool.houge.grpc.AttachBrokerResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AttachBrokerResponse>
      PARSER = new com.google.protobuf.AbstractParser<AttachBrokerResponse>() {
    @java.lang.Override
    public AttachBrokerResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AttachBrokerResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AttachBrokerResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AttachBrokerResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cool.houge.grpc.AttachBrokerResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
