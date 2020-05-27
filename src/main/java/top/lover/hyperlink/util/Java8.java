package top.lover.hyperlink.util;

import top.lover.hyperlink.common.CommonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qinrq
 */
public class Java8 {
    public static void main(String[] args) {
        List<CommonValue> users = new ArrayList<CommonValue>();
        for (int i = 0;i<205;i++){
            CommonValue pushInfoVo = CommonValue.builder().build();
            if(i%3==1){
                pushInfoVo.setMsg(i+"-"+i);
            }else{
                pushInfoVo.setMsg(i+"");
            }
            users.add(pushInfoVo);
        }
        System.out.println("users的大小："+users.size());
        List<String> list = users.stream().filter(pushVo->!pushVo.getMsg().contains("-")).map(CommonValue::getMsg).collect(Collectors.toList());
        System.out.println("list的大小："+list.size());
        int limit = (int) Math.ceil(list.size()/10.0);
        System.out.println(limit);
        List<List<String>> splitList = Stream.iterate(0, n->n+1).limit(limit).parallel().map(a->{
            return list.stream().skip(a*10).limit(10).parallel().collect(Collectors.toList());
        }).collect(Collectors.toList());
        splitList.forEach(list1-> {
            System.out.println("size的大小："+list1.size());
            list1.forEach(l-> System.out.println(l));
        });
    }
}
