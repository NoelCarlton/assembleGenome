import java.util.*;

/**
 * @Description
 * @Author noel
 * @Date 2019/12/5
 * Version 1.0
 **/
public class DeBruijnGraph {

    public static void main(String[] args){
        Integer k = 12;
        String text= "GGGTGACATGTACTCGTATACGTGATCTTCCGGCTGGTCCACGGTTGTCGCTGCCGGGCCATCCGACAACAGTCGTGTGCGCGAACATATCGTCTCGGGCGTCGGTGATCATTAAGTCGATTGTGAAAAGCCGGAGATTGTTTCCACATTGCACAACCAGCTGCAGACGCAGGTGTCTGTGTCCAAACAAATGGTCCGGAGACCACAAAGTTAGACATGAGGCGGAACAATATCCGGAGTTGCGCGAGGAGACCCGTCGAGCTACGGACGCCCCTATACCATCCGTCCAGATTGGCTCAGATAATTTCGCTCCCCCGGACACGGTATACCAGGGCGTGCTAAGGCGAACGGCTTGTGAATCGTTATATATGGTTTGACCACGAAGTAGAGGCGAAGAAGCTAGTAAAAAGTCCAGCGTGTCTGTTGACACAGCCTGAGAGATAGGCCTGAGGTATTTTCGCTCTAAGTGCGAACAATACCAGAACCGAAGGTCTGTAGTTTGACTGGGGGGAAAGCCTTCTTCTGGAAACCGAATGAATCACGAACCCAAAACCTGAACGATCCGTAACCCGCTATGCAGTAAACACGTGGCGATTAGTCCTACGAGGAAACTCGGCGCCTGAATGTGTACCAGCATCCGATAATCGATTTAGTAACGGAACACTCTTCGCAGGACTCTGTCTTATAGTTGAAATTATCTCCGGCCATGGGGTCACATAGAGGGACAGTATTCTCAGCCCAGCGGCTCGAGAGCGCTTGACCACTCGTACTGAGCTTTTTCAAAACTAGGTCGCCAGCTTACATTTAGCCTGGGAACCACCAGTGTACACGCCATGCTAAAGGGTGATGATCGCGTCAGTTTAAACCAGACCCGCTAAGTTGACTGCTACCGAAACCTTCACATGTCACTTCAAATATCTTAAGCTGTATCAAGCTTTGACCCAGCGAGGTCCCCGATTAATCCATTAGGTTACCAACATCTACTCCTTAAACATCCTCTATCGCGCGTACAGAAAGAAGTCATCAGCCAGCGGGATGCCGTCAAGCTAATTCATTTGTAAACCACCCGTCTGAGAATGTAGCAGCCGAGAGGGTGGTACTCCTAGAGCGAGCTAGGTACCGGACAGAACGTAGGTTGTACCGCTTTCCGGATCTACGACTCGACACAAAAATCATTAAGTACAAGCTAATGTCTGGATACTCTTAGTGGAAGCCTGCCCCGACAGTCGATTCCGCCGATGCATTAAGCGCCTGAGATCGTCACTCCTGTCCCCAATGTAATATAGGGTCAGATCACTTTTGCGTTATAAAAGCCACATAGGCAGCAGCGCACTGGGAATGGCAGACGTGCCGATATATAACGAGAGCACCAATAAGGATGAGAGCGCCTGGCAACAGCCATATTTCCATCTCCGATGAGGTAACGCGGATTGGAGTTTCTTGTCAGTTGACCACAAAGTACGCGAACTGCGAAGGCCCGTGTACGCCAAAACAAATCGCCCCCAACAGGCAGTTAGTCATTTGCCGTAATCTTTATTCCGACGATCACGCTTAAGACAGAAAACGAAAGGGAGAGGGGCTGTCGCCGAACGCTACATATACAATTTTCTAAGATAAATCCAAATTTCTGCACAGCGCCCCACCCGATACGCTGCGTGTGGCACGGTAGGTTATAAACTGTGTTCGCTTGTATAATAAGCAGTGTGATCACAAGCAGAAGCTCCCCAGAAGTGATCTTCCCGTTTCCAGAAGTGTAAGGGCCAGATGTTGCGGAGCCCGCAAAAGCACTAACACTCCTGTGGGAATTGTCCTTTGGGTCCGTGAGGTCTGCACGGGAAACCGGTTCCCTATAATAGTCTCGAGTTTACCATTGTCGTGTCGTCTGGCCAATGAGTCTACGAAGGAATGAGGAATGGTAGTTCCATTGAAACGCAGGGCGATGGAACTTTGATTCAGCCACGTTAGGTCGGCTTTCCATTACTTCACAAGACGCGGCATCT";
        List<String> datas = gererate(k, text);
        path(datas,k);
    }

    private static List<String> gererate(Integer k, String text) {
        Integer range = text.length()-k;
        String temp = text.substring(0,text.length());
        List<String> segements = new ArrayList<>();
        for(int i=0;i<=range; i++) {
            String segment = temp.substring(i, k+i);
            segements.add(segment);
            temp = text.substring(0,text.length());
        }
//        Collections.sort(segements);
        for(int i =0 ; i< segements.size();i++) {
            System.out.println(segements.get(i));
        }
        return segements;
    }

    private static void path(List<String> datas, Integer size){
        Map<String,List<String>> result = new HashMap<>();
        for(int i =0; i<datas.size()-1;i++){
            List<String> next;
            String preMer = datas.get(i).substring(0, size);
            String nextMer = datas.get(i+1).substring(0,size);
            String preNode = preMer.substring(0, size-1);
            String nextNode = nextMer.substring(0 , size-1);
            if(result.containsKey(preNode)){
                next = result.get(preNode);
            }else {
                next = new ArrayList<>();
            }
            next.add(nextNode);
            result.put(preNode,next);
        }
        String lastNode = datas.get(datas.size()-1).substring(0,size);
        String lastSecondNode = datas.get(datas.size()-1).substring(0,size);
        String Lastkey = lastSecondNode.substring(1,size);
        String va = lastNode.substring(0,size-1);
        List<String> next;
        if(result.containsKey(va)){
            next = result.get(va);
        }else {
            next = new ArrayList<>();
        }
        next.add(Lastkey);
        result.put(va,next);
        Object[] kys = result.keySet().toArray();
        Arrays.sort(kys);
        for(Object key : kys){
            List<String> values = result.get(key);
            Integer length = values.size();
            if(length==1){
                System.out.println(key+" -> "+ values.get(0));
            }else{
                System.out.print(key+" -> "+ values.get(0));
                for(int i = 1; i<length; i++){
                    System.out.print(","+ values.get(i));
                }
                System.out.println();
            }
        }
    }

}
