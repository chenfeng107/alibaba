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
    internal_static_CreateTokenRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateTokenRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateTokenResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateTokenResponse_fieldAccessorTable;
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
      "\n\033cool/houge/grpc/token.proto\"!\n\022CreateT" +
      "okenRequest\022\013\n\003uid\030\001 \001(\005\"$\n\023CreateTokenR" +
      "esponse\022\r\n\005token\030\001 \001(\t\"#\n\022VerifyTokenReq" +
      "uest\022\r\n\005token\030\001 \001(\t\"\"\n\023VerifyTokenRespon" +
      "se\022\013\n\003uid\030\001 \001(\0052u\n\005Token\0225\n\006Create\022\023.Cre" +
      "ateTokenRequest\032\024.CreateTokenResponse\"\000\022" +
      "5\n\006Verify\022\023.VerifyTokenRequest\032\024.VerifyT" +
      "okenResponse\"\000B\023\n\017cool.houge.grpcP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_CreateTokenRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CreateTokenRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateTokenRequest_descriptor,
        new java.lang.String[] { "Uid", });
    internal_static_CreateTokenResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CreateTokenResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateTokenResponse_descriptor,
        new java.lang.String[] { "Token", });
    internal_static_VerifyTokenRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_VerifyTokenRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VerifyTokenRequest_descriptor,
        new java.lang.String[] { "Token", });
    internal_static_VerifyTokenResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_VerifyTokenResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VerifyTokenResponse_descriptor,
        new java.lang.String[] { "Uid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
