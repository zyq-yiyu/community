package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"问题不存在"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题回复"),
    NO_LOGIN(2003,"当前操作需要登录"),
    SYS_ERROR(2004,"服务器问题"),
    TYPE_PARAM_WRONG(2005,"评论类型不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不在了"),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空"),
    ;
@Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getcode() {
        return code;
    }


    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
