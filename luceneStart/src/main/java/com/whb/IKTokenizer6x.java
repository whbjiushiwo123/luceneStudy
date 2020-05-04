package com.whb;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

public class IKTokenizer6x extends Tokenizer {
    // IK�ִ���ʵ��
    private IKSegmenter _IKImplement;

    // ��Ԫ�ı�����
    private final CharTermAttribute termAtt;

    // ��Ԫλ������
    private final OffsetAttribute offsetAtt;

    // ��Ԫ�������ԣ������Է���ο�org.wltea.analyzer.core.Lexeme�еķ��ೣ����
    private final TypeAttribute typeAtt;

    // ��¼���һ����Ԫ�Ľ���λ��
    private int endPosition;

    // Lucene 6.x Tokenizer�������๹�캯��;ʵ�����µ�Tokenizer�ӿ�
    public IKTokenizer6x(boolean userSmart){
        super();
        offsetAtt = addAttribute(OffsetAttribute.class);
        termAtt = addAttribute(CharTermAttribute.class);
        typeAtt = addAttribute(TypeAttribute.class);
        _IKImplement = new IKSegmenter(input,userSmart);
    }
    @Override
    public boolean incrementToken() throws IOException {
        // ������еĴ�Ԫ����
        clearAttributes();
        Lexeme nextLexeme = _IKImplement.next();
        if (nextLexeme != null) {
            // ��Lexemeת��Attributes
            // ���ô�Ԫ�ı�
            termAtt.append(nextLexeme.getLexemeText());
            // ���ô�Ԫ����
            termAtt.setLength(nextLexeme.getLength());
            // ���ô�Ԫλ��
            offsetAtt.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
            // ��¼�ִʵ����λ��
            endPosition = nextLexeme.getEndPosition();
            // ��¼��Ԫ����
            typeAtt.setType(nextLexeme.getLexemeText());
            // ����true��֪�����¸���Ԫ
            return true;
        }
        // ����false��֪��Ԫ������
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        _IKImplement.reset(input);
    }

    @Override
    public final void end() {
        int finalOffset = correctOffset(this.endPosition);
        offsetAtt.setOffset(finalOffset, finalOffset);
    }

}
