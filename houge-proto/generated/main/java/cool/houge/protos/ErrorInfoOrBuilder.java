// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/protos/error.proto

package cool.houge.protos;

public interface ErrorInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ErrorInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>int32 httpStatus = 3;</code>
   * @return The httpStatus.
   */
  int getHttpStatus();

  /**
   * <code>map&lt;string, .google.protobuf.Value&gt; details = 9;</code>
   */
  int getDetailsCount();
  /**
   * <code>map&lt;string, .google.protobuf.Value&gt; details = 9;</code>
   */
  boolean containsDetails(
      java.lang.String key);
  /**
   * Use {@link #getDetailsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.protobuf.Value>
  getDetails();
  /**
   * <code>map&lt;string, .google.protobuf.Value&gt; details = 9;</code>
   */
  java.util.Map<java.lang.String, com.google.protobuf.Value>
  getDetailsMap();
  /**
   * <code>map&lt;string, .google.protobuf.Value&gt; details = 9;</code>
   */

  com.google.protobuf.Value getDetailsOrDefault(
      java.lang.String key,
      com.google.protobuf.Value defaultValue);
  /**
   * <code>map&lt;string, .google.protobuf.Value&gt; details = 9;</code>
   */

  com.google.protobuf.Value getDetailsOrThrow(
      java.lang.String key);
}
