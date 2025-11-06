package classified;

import java.util.ArrayList;
import java.util.UUID;

import exceptions.InvalidUserTypeForShadowComitee;
import exceptions.MatchingUsernameNotFound;
import exceptions.SakuraIsAllPower;
import services.AuthService;
import users.*;


public class ShadowCommittee {
    private ArrayList<User> ShadowCommittee = new ArrayList<>();
    private UUID uuid = UUID.randomUUID();

    public ShadowCommittee() throws InvalidUserTypeForShadowComitee {
        //Example data
        Sakura sakura = Sakura.getInstance();
        ShadowCommittee.add(sakura); //Sakura is part of all shadows committee (supposed to be multiple shadow committees)

    }

    public void addUser(User user) throws InvalidUserTypeForShadowComitee {
       if(user instanceof UserAdmin || user instanceof ContentAdmin || user instanceof Sakura){
           ShadowCommittee.add(user);
       } else  {
           throw new InvalidUserTypeForShadowComitee("Invalid user type, it has to be a ContentAdmin, UserAdmin or Sakura");
       }
    }

    public void listUsers() {
        for (User user : ShadowCommittee) {
            System.out.println(user.getUsername() + " " + user.getEmail() + " " + user.getRole());
        }
    }

    public void removeUser(String username) throws SakuraIsAllPower{
        for(User user : ShadowCommittee) {
            if(user.getUsername().equals(username)) {
                if (user instanceof Sakura) {
                    throw new SakuraIsAllPower("Sakura is all powerful you cant remove her !");
                }
                ShadowCommittee.remove(user);
                break;
            }
        }

    }

    public boolean isMember(String username) throws MatchingUsernameNotFound {
        for(User user : ShadowCommittee) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        throw new MatchingUsernameNotFound("No member found for username " + username);

    }

    public User getMember(String username) throws MatchingUsernameNotFound {
        for(User user : ShadowCommittee) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new MatchingUsernameNotFound("User not found for this username " + username);
    }


}
