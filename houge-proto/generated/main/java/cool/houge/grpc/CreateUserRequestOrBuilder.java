// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/user.proto

package cool.houge.grpc;

public interface CreateUserRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CreateUserRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 用户ID.
   * </pre>
   *
   * <code>int32 uid = 1;</code>
   * @return The uid.
   */
  int getUid();

  /**
   * <pre>
   * 原系统用户ID.
   * </pre>
   *
   * <code>string origin_uid = 2;</code>
   * @return The originUid.
   */
  java.lang.String getOriginUid();
  /**
   * <pre>
   * 原系统用户ID.
   * </pre>
   *
   * <code>string origin_uid = 2;</code>
   * @return The bytes for originUid.
   */
  com.google.protobuf.ByteString
      getOriginUidBytes();
}
