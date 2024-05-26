import java.util.*;


class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, User> userMap = getUserMap(friends);
        
        giftRecord(userMap, gifts);
        
        
        return getMaxGiftNum(userMap, friends);
    }
    
    // 결과 반환
    public int getMaxGiftNum(Map<String, User> userMap, String[] friends) {
        
        int answer = 0;
        
        for(String userName : friends) {
            
            int count = 0;
            User user = userMap.get(userName);
            
            for(String friendName : friends) {
                
                if (friendName.equals(userName)) continue;
                                
                User friendUser = userMap.get(friendName);
                int userToFriendGiftNum = user.getSendGiftNumForUser(friendName);
                int friendToUserGiftNum = friendUser.getSendGiftNumForUser(userName);
                
                if ( userToFriendGiftNum > friendToUserGiftNum ) {
                    count++;
                } else if ( userToFriendGiftNum == friendToUserGiftNum && user.getGiftIndex() > friendUser.getGiftIndex()) {
                    count++;
                }
                                
            }
            
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
    
    
    public void giftRecord(Map<String, User> userMap, String[] gifts) {
        
        for (String gift : gifts) {
            String[] giftUserName = gift.split(" ");
            
            String sendUserName = giftUserName[0];
            String recievedUserName = giftUserName[1];
            
            User sendUser = userMap.get(sendUserName);
            User recievedUser = userMap.get(recievedUserName);
            
            // 선물 개수 올리기
            sendUser.incSendGiftNum();
            recievedUser.incReceivedGiftNum();
             
            sendUser.giveGiftForUser(recievedUserName);
        }
        
    }
    
    
    // 초기 셋팅
    public Map<String, User> getUserMap(String[] friends) {
        
        Map<String, User> userMap = new HashMap<String, User>();
        
        for (String friend : friends) {
            userMap.put(friend, new User(friend));
        }
        
        return userMap;
        
    }
    
    
    class User {
        
        String name;
        
        int sendGiftNum; // 보낸 선물 
        int receivedGiftNum; // 받은 선물
        
        Map<String, Integer> giftSendUserMap;
        
        public User(String name) {
            this.name = name;
            giftSendUserMap = new HashMap<>();
        }
        
        public void incSendGiftNum() {
            sendGiftNum++;
        }
        
        public void incReceivedGiftNum() {
            receivedGiftNum++;
        }
        
        public void giveGiftForUser(String userName) {
            
            if (giftSendUserMap.containsKey(userName)) {
                giftSendUserMap.put(userName, giftSendUserMap.get(userName) + 1);
            } else {
                giftSendUserMap.put(userName, 1);
            }
            
        }
        
        public int getSendGiftNumForUser(String userName) {
            
            if (giftSendUserMap.containsKey(userName)) {
                return giftSendUserMap.get(userName);
            } 
            
            return 0;
            
        }
        
        // 선물 지수
        public int getGiftIndex() {
            return sendGiftNum - receivedGiftNum;
        }
        
    }
}
