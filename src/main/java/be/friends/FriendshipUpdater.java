package be.friends;

public class FriendshipUpdater {

    final Friend[] friends;

    public FriendshipUpdater(Friend[] friends) {
        this.friends = friends;
    }

    public void update() {
        for (Friend friend : friends) {
            friendUpdate(friend);
        }
    }

    private void friendUpdate(Friend friend) {
        if (friend.didSomeInteractionToday) {
            if (friend.nrOfStars == 0) {
                friend.nrOfStars++;
            } else if(friend.friendshipLevel == 9 && friend.nrOfStars == 1){
                friend.friendshipLevel = 0;
                friend.nrOfStars = 2;
            } else {
                friend.friendshipLevel++;
            }

            if (friend.nrOfStars == 2 && friend.friendshipLevel == 30) {
                friend.friendshipLevel = 0;
                friend.nrOfStars++;
            }

            if(friend.isLucky) {
                friend.isLucky = false;
                friend.friendshipLevel +=4;
            }
        }
    }
}