package com.whb;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

public class IKAnalyzer6x  extends Analyzer {
    private boolean useSmart;

    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    // IK�ִ���Lucene Analyzer�ӿ�ʵ����;Ĭ��ϸ�����з��㷨
    public IKAnalyzer6x (){
        this(false);
    }
    // IK�ִ���Lucene Analyzer�ӿ�ʵ����;��Ϊtrueʱ���ִ������������з�
    public IKAnalyzer6x (boolean useSmart){
        super();
        this.useSmart = useSmart;
    }

    // ��д���°汾��createComponents;����Analyzer�ӿڣ�����ִ����
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer _IKTokenizer = new IKTokenizer6x(this.useSmart());
        return new TokenStreamComponents(_IKTokenizer);
    }
}
