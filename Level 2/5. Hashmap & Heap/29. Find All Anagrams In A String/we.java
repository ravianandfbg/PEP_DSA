class Solution {
      public List<Integer> findAnagrams(String s, String p) {
          List<Integer>ans = new ArrayList<>();
          
          if(p.length() > s.length()) {
              return ans;
          }
          // pm : pattern map
          HashMap<Character,Integer>pm = new HashMap<>(); //freq map of pattern
          
          //freq map of pattern(p)
          for(int i=0; i < p.length();i++) {
              char ch = p.charAt(i);
              int nFreq = pm.getOrDefault(ch,0) + 1;
              pm.put(ch,nFreq);
          }
          
          // wm : window map
          HashMap<Character,Integer>wm = new HashMap<>(); //freq map of window
          
          //freq map of first window in s
          int i = 0;
          int j = 0;
          
          for(i=0; i < p.length();i++) {
              char ch = s.charAt(i);
              int nFreq = wm.getOrDefault(ch,0) + 1;
              wm.put(ch,nFreq);
          }
          
          
          
          for(; i < s.length();i++,j++) {
              if(areMapsEqual(wm,pm) == true) {
                  ans.add(j);
              }
              
              //aquire ith char
              char chi = s.charAt(i);
              int nFreqi = wm.getOrDefault(chi,0) + 1;
              wm.put(chi,nFreqi);
              
              //release jth char
              char chj = s.charAt(j);
              
              if(wm.get(chj) == 1) {
                  wm.remove(chj);
              }
              else {
                  int nFreqj = wm.get(chj) - 1;
                  wm.put(chj,nFreqj);
              }
          }
          
          
          
          if(areMapsEqual(wm,pm) == true) {
              ans.add(j);
          }
          
          return ans;
          
      }
      
      public static boolean areMapsEqual(HashMap<Character,Integer>fm1,HashMap<Character,Integer>fm2) {
          // fm1 : frequency map 1 , fm2 : frequency map 2
          if(fm1.size() != fm2.size()) {
              return false;
          }
          
          for(char ch : fm1.keySet()) {
              int f1 = fm1.get(ch);
              int f2 = fm2.getOrDefault(ch,0);
              
              if(f1 != f2) {
                  return false;
              }
          }
          
          return true;
          
      }
  }