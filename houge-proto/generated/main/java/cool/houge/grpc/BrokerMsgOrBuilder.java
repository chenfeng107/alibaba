// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cool/houge/grpc/broker.proto

package cool.houge.grpc;

public interface BrokerMsgOrBuilder extends
    // @@protoc_insertion_point(interface_extends:BrokerMsg)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 消息类型
   * </pre>
   *
   * <code>.MsgKind kind = 1;</code>
   * @return The enum numeric value on the wire for kind.
   */
  int getKindValue();
  /**
   * <pre>
   * 消息类型
   * </pre>
   *
   * <code>.MsgKind kind = 1;</code>
   * @return The kind.
   */
  cool.houge.protos.MsgKind getKind();

  /**
   * <pre>
   * 消息ID
   * </pre>
   *
   * <code>string msgId = 2;</code>
   * @return The msgId.
   */
  java.lang.String getMsgId();
  /**
   * <pre>
   * 消息ID
   * </pre>
   *
   * <code>string msgId = 2;</code>
   * @return The bytes for msgId.
   */
  com.google.protobuf.ByteString
      getMsgIdBytes();

  /**
   * <pre>
   * 消息发送者
   * </pre>
   *
   * <code>fixed32 from = 3;</code>
   * @return The from.
   */
  int getFrom();

  /**
   * <pre>
   * 消息接收者
   * </pre>
   *
   * <code>fixed32 to = 4;</code>
   * @return The to.
   */
  int getTo();

  /**
   * <pre>
   * 消息内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <pre>
   * 消息内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <pre>
   * 消息内容类型
   * </pre>
   *
   * <code>.MsgContentType content_type = 6;</code>
   * @return The enum numeric value on the wire for contentType.
   */
  int getContentTypeValue();
  /**
   * <pre>
   * 消息内容类型
   * </pre>
   *
   * <code>.MsgContentType content_type = 6;</code>
   * @return The contentType.
   */
  cool.houge.protos.MsgContentType getContentType();

  /**
   * <pre>
   * 扩展参数会原样转发给客户端
   * </pre>
   *
   * <code>optional string extra = 9;</code>
   * @return Whether the extra field is set.
   */
  boolean hasExtra();
  /**
   * <pre>
   * 扩展参数会原样转发给客户端
   * </pre>
   *
   * <code>optional string extra = 9;</code>
   * @return The extra.
   */
  java.lang.String getExtra();
  /**
   * <pre>
   * 扩展参数会原样转发给客户端
   * </pre>
   *
   * <code>optional string extra = 9;</code>
   * @return The bytes for extra.
   */
  com.google.protobuf.ByteString
      getExtraBytes();
}
