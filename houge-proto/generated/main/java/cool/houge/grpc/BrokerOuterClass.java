// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/broker.proto

package cool.houge.grpc;

public final class BrokerOuterClass {
  private BrokerOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BrokerMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BrokerMsg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BrokerCommand_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BrokerCommand_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AttachBrokerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AttachBrokerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AttachBrokerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AttachBrokerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034cool/houge/grpc/broker.proto\032!cool/hou" +
      "ge/protos/msg_enums.proto\"\223\001\n\tBrokerMsg\022" +
      "\026\n\004kind\030\001 \001(\0162\010.MsgKind\022\r\n\005msgId\030\002 \001(\t\022\014" +
      "\n\004from\030\003 \001(\007\022\n\n\002to\030\004 \001(\007\022\017\n\007content\030\005 \001(" +
      "\t\022%\n\014content_type\030\006 \001(\0162\017.MsgContentType" +
      "\022\r\n\005extra\030\t \001(\t\"\035\n\rBrokerCommand\022\014\n\004name" +
      "\030\001 \001(\t\"#\n\023AttachBrokerRequest\022\014\n\004name\030\001 " +
      "\001(\t\"\\\n\024AttachBrokerResponse\022\031\n\003msg\030\001 \001(\013" +
      "2\n.BrokerMsgH\000\022!\n\007command\030\t \001(\0132\016.Broker" +
      "CommandH\000B\006\n\004kind2C\n\006Broker\0229\n\006Attach\022\024." +
      "AttachBrokerRequest\032\025.AttachBrokerRespon" +
      "se\"\0000\001B\023\n\017cool.houge.grpcP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.houge.protos.MsgEnums.getDescriptor(),
        });
    internal_static_BrokerMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BrokerMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BrokerMsg_descriptor,
        new java.lang.String[] { "Kind", "MsgId", "From", "To", "Content", "ContentType", "Extra", });
    internal_static_BrokerCommand_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_BrokerCommand_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BrokerCommand_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_AttachBrokerRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_AttachBrokerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AttachBrokerRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_AttachBrokerResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_AttachBrokerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AttachBrokerResponse_descriptor,
        new java.lang.String[] { "Msg", "Command", "Kind", });
    cool.houge.protos.MsgEnums.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
