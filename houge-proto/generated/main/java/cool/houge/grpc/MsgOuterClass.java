// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/msg.proto

package cool.houge.grpc;

public final class MsgOuterClass {
  private MsgOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMsgIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateMsgIdRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMsgIdResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateMsgIdResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMsgIdsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateMsgIdsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMsgIdsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateMsgIdsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SendMsgRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SendMsgRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SendMsgResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SendMsgResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031cool/houge/grpc/msg.proto\032!cool/houge/" +
      "protos/msg_enums.proto\"\024\n\022CreateMsgIdReq" +
      "uest\"%\n\023CreateMsgIdResponse\022\016\n\006msg_id\030\001 " +
      "\001(\t\"$\n\023CreateMsgIdsRequest\022\r\n\005count\030\001 \001(" +
      "\005\"&\n\024CreateMsgIdsResponse\022\016\n\006msg_id\030\001 \003(" +
      "\t\"\201\001\n\016SendMsgRequest\022\016\n\006msg_id\030\001 \001(\t\022\014\n\004" +
      "from\030\002 \001(\007\022\n\n\002to\030\003 \001(\007\022\017\n\007content\030\004 \001(\t\022" +
      "%\n\014content_type\030\005 \001(\0162\017.MsgContentType\022\r" +
      "\n\005extra\030\t \001(\t\"!\n\017SendMsgResponse\022\016\n\006msg_" +
      "id\030\001 \001(\t2\341\001\n\003Msg\0227\n\010CreateId\022\023.CreateMsg" +
      "IdRequest\032\024.CreateMsgIdResponse\"\000\022:\n\tCre" +
      "ateIds\022\024.CreateMsgIdsRequest\032\025.CreateMsg" +
      "IdsResponse\"\000\0221\n\nSendToUser\022\017.SendMsgReq" +
      "uest\032\020.SendMsgResponse\"\000\0222\n\013SendToGroup\022" +
      "\017.SendMsgRequest\032\020.SendMsgResponse\"\000B\023\n\017" +
      "cool.houge.grpcP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.houge.protos.MsgEnums.getDescriptor(),
        });
    internal_static_CreateMsgIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CreateMsgIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateMsgIdRequest_descriptor,
        new java.lang.String[] { });
    internal_static_CreateMsgIdResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CreateMsgIdResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateMsgIdResponse_descriptor,
        new java.lang.String[] { "MsgId", });
    internal_static_CreateMsgIdsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CreateMsgIdsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateMsgIdsRequest_descriptor,
        new java.lang.String[] { "Count", });
    internal_static_CreateMsgIdsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_CreateMsgIdsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateMsgIdsResponse_descriptor,
        new java.lang.String[] { "MsgId", });
    internal_static_SendMsgRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_SendMsgRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SendMsgRequest_descriptor,
        new java.lang.String[] { "MsgId", "From", "To", "Content", "ContentType", "Extra", });
    internal_static_SendMsgResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_SendMsgResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SendMsgResponse_descriptor,
        new java.lang.String[] { "MsgId", });
    cool.houge.protos.MsgEnums.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
