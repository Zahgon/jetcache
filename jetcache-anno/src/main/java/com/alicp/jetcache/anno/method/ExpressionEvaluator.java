/**
 * Created on 2018/1/19.
 */
package com.alicp.jetcache.anno.method;

import com.alicp.jetcache.CacheConfigException;
import org.mvel2.MVEL;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangli
 */
public class ExpressionEvaluator implements Function<Object, Object> {

    private static final Pattern pattern = Pattern.compile("\\s*(\\w+)\\s*\\{(.+)\\}\\s*");

    private Function<Object, Object> target;

    public ExpressionEvaluator(String script, Method defineMethod) {
        Object[] rt = parseEL(script);
        EL el = (EL) rt[0];
        String realScript = (String) rt[1];
        if (el == EL.MVEL) {
            target = new MvelEvaluator(realScript);
        } else if (el == EL.SPRING_EL) {
            target = new SpelEvaluator(realScript, defineMethod);
        }
    }

    private Object[] parseEL(String script) {
        if (script == null || script.trim().equals("")) {
            return null;
        }
        Object[] rt = new Object[2];
        Matcher matcher = pattern.matcher(script);
        if (!matcher.matches()) {
            // default spel since 2.4
            rt[0] = EL.SPRING_EL;
            rt[1] = script;
            return rt;
        } else {
            String s = matcher.group(1);
            if ("spel".equals(s)) {
                rt[0] = EL.SPRING_EL;
            } else if ("mvel".equals(s)) {
                rt[0] = EL.MVEL;
            } else /* else if ("buildin".equals(s)) {
                rt[0] = EL.BUILD_IN;
            } */
            {
                throw new CacheConfigException("Can't parse \"" + script + "\"");
            }
            rt[1] = matcher.group(2);
            return rt;
        }
    }

    @Override
    public Object apply(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Function<Object, Object> getTarget() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

class MvelEvaluator implements Function<Object, Object> {

    private String script;

    public MvelEvaluator(String script) {
        this.script = script;
    }

    @Override
    public Object apply(Object context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

class SpelEvaluator implements Function<Object, Object> {

    private static ExpressionParser parser;

    private static ParameterNameDiscoverer parameterNameDiscoverer;

    static {
        parser = new SpelExpressionParser();
        parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
    }

    private final Expression expression;

    private String[] parameterNames;

    public SpelEvaluator(String script, Method defineMethod) {
        expression = parser.parseExpression(script);
        if (defineMethod.getParameterCount() > 0) {
            parameterNames = parameterNameDiscoverer.getParameterNames(defineMethod);
        }
    }

    @Override
    public Object apply(Object rootObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
