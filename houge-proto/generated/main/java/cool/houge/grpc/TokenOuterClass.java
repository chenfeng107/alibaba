// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/token.proto

package cool.houge.grpc;

public final class TokenOuterClass {
  private TokenOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VerifyTokenRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VerifyTokenRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VerifyTokenResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VerifyTokenResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033cool/houge/grpc/token.proto\"#\n\022VerifyT" +
      "okenRequest\022\r\n\005token\030\001 \001(\t\"\"\n\023VerifyToke" +
      "nResponse\022\013\n\003uid\030\001 \001(\0052>\n\005Token\0225\n\006Verif" +
      "y\022\023.VerifyTokenRequest\032\024.VerifyTokenResp" +
      "onse\"\000B\023\n\017cool.houge.grpcP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_VerifyTokenRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_VerifyTokenRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VerifyTokenRequest_descriptor,
        new java.lang.String[] { "Token", });
    internal_static_VerifyTokenResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_VerifyTokenResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VerifyTokenResponse_descriptor,
        new java.lang.String[] { "Uid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}