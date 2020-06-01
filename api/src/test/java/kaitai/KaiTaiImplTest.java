package kaitai;

import ognl.*;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.IOException;

public class KaiTaiImplTest {




    @Test
    public void testGif() throws IOException, OgnlException {
        com.iotpack.kaitai.Gif g = com.iotpack.kaitai.Gif.fromFile("C:\\Users\\Admin\\IdeaProjects\\iotpack\\misc\\testfile\\test1.gif");

        System.out.println("width = " + g.logicalScreen().imageHeight());

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("logicalScreen().imageHeight()");

        EvaluationContext context = new StandardEvaluationContext(g);

        int width = (int) exp.getValue(context);
        System.out.println(width);

//        System.out.println("width = "+ognlExpression.getValue(g,g).toString());
    }
}
