package com.whb;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Paths;

public class LuceneDemo {
    private static String str ="�л����񹲺͹�����й�,  ��һ����13���˿ڵĹ���";

    public static void main(String[] args) throws IOException {
        Analyzer analyzer = null;

        analyzer = new StandardAnalyzer();// ��׼�ִ�
        System.out.println("��׼�ִ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new WhitespaceAnalyzer(); // �ո�ִ�
        System.out.println("�ո�ִ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new SimpleAnalyzer(); // �򵥷ִ�
        System.out.println("�򵥷ִ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new CJKAnalyzer(); // ���ַ��ִ�
        System.out.println("���ַ��ִ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new KeywordAnalyzer(); // �ؼ��ִַ�
        System.out.println("�ؼ��ִַ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        String file = new String("H:\\spring\\luceneStudy\\luceneStart\\dic\\stopword.dic");
        Reader r = new FileReader(file);
        analyzer = new StopAnalyzer(r);
        //analyzer = new StopAnalyzer();

        // ͣ�ôʷִ�
        System.out.println("ͣ�ôʷִ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new SmartChineseAnalyzer(); // �������ִܷ�
        System.out.println("�������ִܷ�:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new IKAnalyzer6x(); // IK�ִ�(ϸ�����з��㷨)
        System.out.println("IK�ִ�(ϸ�����з��㷨):" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new IKAnalyzer6x(true); // IK�ִ�(�����з��㷨)
        System.out.println("IK�ִ�(�����з��㷨):" + analyzer.getClass());
        printAnalyzer(analyzer);
    }

    public static void printAnalyzer(Analyzer analyzer) throws IOException {
        StringReader reader = new StringReader(str);
        TokenStream toStream = analyzer.tokenStream(str, reader);
        toStream.reset();// �����
        CharTermAttribute teAttribute = toStream.getAttribute(CharTermAttribute.class);
        while (toStream.incrementToken()) {
            System.out.print(teAttribute.toString() + "|");
        }
        System.out.println("\n");
        analyzer.close();
    }
}
