// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/protos/error.proto

package cool.houge.protos;

public final class Error {
  private Error() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ErrorInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ErrorInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ErrorInfo_DetailsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ErrorInfo_DetailsEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035cool/houge/protos/error.proto\032\034google/" +
      "protobuf/struct.proto\"\260\001\n\tErrorInfo\022\014\n\004c" +
      "ode\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\022\022\n\nhttpStatus" +
      "\030\003 \001(\005\022(\n\007details\030\t \003(\0132\027.ErrorInfo.Deta" +
      "ilsEntry\032F\n\014DetailsEntry\022\013\n\003key\030\001 \001(\t\022%\n" +
      "\005value\030\002 \001(\0132\026.google.protobuf.Value:\0028\001" +
      "B\025\n\021cool.houge.protosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.StructProto.getDescriptor(),
        });
    internal_static_ErrorInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ErrorInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ErrorInfo_descriptor,
        new java.lang.String[] { "Code", "Message", "HttpStatus", "Details", });
    internal_static_ErrorInfo_DetailsEntry_descriptor =
      internal_static_ErrorInfo_descriptor.getNestedTypes().get(0);
    internal_static_ErrorInfo_DetailsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ErrorInfo_DetailsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    com.google.protobuf.StructProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
