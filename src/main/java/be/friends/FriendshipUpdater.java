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
            friend.friendshipLevel++;

            updateIncreaseStar(friend);

            if(friend.isLucky) {
                friend.isLucky = false;
                friend.friendshipLevel +=4;
            }
        }
    }

    private void updateIncreaseStar(Friend friend) {
        if(friend.nrOfStars == 0 ||
            friend.friendshipLevel == 10 && friend.nrOfStars == 1 ||
            friend.nrOfStars == 2 && friend.friendshipLevel == 30)
        {
            friend.friendshipLevel = 0;
            friend.nrOfStars++;
        }
    }
}