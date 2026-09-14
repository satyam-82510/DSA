class Solution {
    public String intToRoman(int num) {
        //METHOD 1 : USING MAP- LINKED HASHMAP
        // TC= O(1), SC = O(1)
//    //  also Map<Integer,String> map = new LinkedHashMap<>();
//        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
//         map.put(1000, "M");
//         map.put(900,"CM");
//         map.put(500,"D");
//         map.put(400,"CD");
//         map.put(100,"C");
//         map.put(90,"XC");
//         map.put(50,"L");
//         map.put(40,"XL");
//         map.put(10,"X");
//         map.put(9,"IX");
//         map.put(5,"V");
//         map.put(4,"IV");
//         map.put(1,"I");
        
//         StringBuilder result= new StringBuilder();
//         // note - for(Map (.) Entry<Integer,String> ent : map.entrySet()){
//         for(LinkedHashMap.Entry<Integer,String> ent : map.entrySet()){
//             int value = ent.getKey();
//             String symbol= ent.getValue();

//             while(num>=value){
//                 result.append(symbol);
//                 num -=value;
//             }
//         }
//     return result.toString();
//     }
// }

// USING ARRAY OF INT AND STRING
//  TC= O(1), SC = O(1)
    String roman = "";
    int value[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romanletters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
                    
//   CORRECT BUT SLOW:  for(int i=0;i<value.length;i++){
//         while(num>=value[i]){
//         roman += romanletters[i];
//         num -= value[i];
//         }
//     }
//     return roman ;
//     }
// }

    StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num -= value[i];
                sb.append(romanletters[i]);
            }
        }
    return sb.toString();
    }
}