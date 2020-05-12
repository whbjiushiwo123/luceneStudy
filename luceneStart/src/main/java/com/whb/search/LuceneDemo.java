package com.whb.search;

/*
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
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class LuceneDemo {
    private static String str ="中华人民共和国简称中国,  是一个有13亿人口的国家";

    public static void main(String[] args) throws IOException {
       /* Analyzer analyzer = null;

        analyzer = new StandardAnalyzer();// 标准分词
        System.out.println("标准分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new WhitespaceAnalyzer(); // 空格分词
        System.out.println("空格分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new SimpleAnalyzer(); // 简单分词
        System.out.println("简单分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new CJKAnalyzer(); // 二分法分词
        System.out.println("二分法分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new KeywordAnalyzer(); // 关键字分词
        System.out.println("关键字分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        String file = new String("H:\\spring\\luceneStudy\\luceneStart\\dic\\stopword.dic");
        Reader r = new FileReader(file);
        analyzer = new StopAnalyzer(r);
        //analyzer = new StopAnalyzer();

        // 停用词分词
        System.out.println("停用词分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new SmartChineseAnalyzer(); // 中文智能分词
        System.out.println("中文智能分词:" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new IKAnalyzer6x(); // IK分词(细粒度切分算法)
        System.out.println("IK分词(细粒度切分算法):" + analyzer.getClass());
        printAnalyzer(analyzer);

        analyzer = new IKAnalyzer6x(true); // IK分词(智能切分算法)
        System.out.println("IK分词(智能切分算法):" + analyzer.getClass());
        printAnalyzer(analyzer);*/
    }
/*
    public static void printAnalyzer(Analyzer analyzer) throws IOException {
        StringReader reader = new StringReader(str);
        TokenStream toStream = analyzer.tokenStream(str, reader);
        toStream.reset();// 清空流
        CharTermAttribute teAttribute = toStream.getAttribute(CharTermAttribute.class);
        while (toStream.incrementToken()) {
            System.out.print(teAttribute.toString() + "|");
        }
        System.out.println("\n");
        analyzer.close();
    }*/
}
