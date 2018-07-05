package com.zyh.zyhTest.Constants;

/**
 * Created by Administrator on 2017/6/28/0028.
 */
public class Constants {

    /**
     * 消息摘要加密方法
     */
    public final static String MESSAGE_DIGEST_MD5 = "MD5";
    public final static String MESSAGE_DIGEST_SHA1 = "SHA-1";
    public final static String MESSAGE_DIGEST_SHA256 = "SHA-256";

    /**
     *验签加密时使用
     */
    public final static String RANDOM_SIGN_STRING = "Se^#4%e-b8#o)&nS^5h@^a!b%7*a_%^o";

    /**
     * redis key前缀
     */
    public final static String REDIS_KEY_PREFIX_TOKEN = "TOKEN_";//token前缀

    /**
     * 日志跟踪id
     */
    public final static String TRACE_LOG_ID = "traceLogId";

    /**
     * XssFilter正则表达式
     */
    //public final static String XSS_FILTER_REG_EX="[`~!@#$%^&*()+=|''\\<>/?~！@#￥%……&*（）——+|{}【】‘”“’？]|(script)|(alert)|(prompt)|(confirm)|(xml)|(style)|(link)|(1=1)|(function)|(img)|(exe)|(msi)|(com)|(cn)|(co)|(www)|(http)|(https)|(&gt)|(&lt)|(&quot)|(db_name)|(user)|(database)|(disk)|(create)|(temp)|(delete)|(is_member)|(is_srvrolemember)|(declare)|(create table)|(delete table)";
    public final static String XSS_FILTER_REG_EX="(script)|(alert)|(prompt)|(confirm)|(xml)|(link)|(function)|(img)|(exe)|(msi)|(http)|(https)|(&gt)|(&lt)|(&quot)|(db_name)|(database)|(disk)|(create)|(temp)|(delete)|(is_member)|(is_srvrolemember)|(declare)|(create table)|(delete table)";
}
