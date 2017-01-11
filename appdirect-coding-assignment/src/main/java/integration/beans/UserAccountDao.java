package integration.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author akanksha
 *
 */
public class UserAccountDao {

    private List<UserAccount> userAccounts;

    public UserAccountDao() {
        this.userAccounts = new ArrayList<UserAccount>();
    }
    
    public List<UserAccount> getAllUserAccounts(){
		return userAccounts;
	} 
	
	/**
	 * @param uuid
	 * @return
	 */
	public UserAccount getUserAccountByUUID(String uuid) {
		for (UserAccount userAccount : userAccounts) {
			if (userAccount.getUuid().equals(uuid))
				return userAccount;
		}
		return null;
	}
	
	/**
	 * @param accountIdentifier
	 * @return
	 */
	public UserAccount getUserAccountByAccountIdentifier(String accountIdentifier) {
		for (UserAccount userAccount : userAccounts) {
			if (userAccount.getAccountIdentifier().equals(accountIdentifier))
				return userAccount;
		}
		return null;
	}
	
	/**
	 * @param uuid
	 * @param subscription
	 * @return
	 */
	public String createUserAccount(String uuid, Order subscription) {
		String accountIdentifier = UUID.randomUUID().toString();
		UserAccount user = new UserAccount(accountIdentifier, uuid, subscription);
		userAccounts.add(user);
		return accountIdentifier;
	}
	
	/**
	 * @param accountIdentifier
	 * @param subscription
	 * @return
	 */
	public boolean updateUserAccount(String accountIdentifier, Order subscription) {
		UserAccount userAccount = getUserAccountByAccountIdentifier(accountIdentifier);
		if (userAccount != null) {
			userAccount.setSubscription(subscription);
			return true;
		}
		return false;
	}
	
	/**
	 * @param accountIdentifier
	 * @return
	 */
	public boolean removeUserAccount(String accountIdentifier) {
		for (UserAccount userAccount : userAccounts) {
			if (userAccount.getAccountIdentifier().equals(accountIdentifier)) {
				userAccounts.remove(userAccount); 
				return true;
			}
		}
		return false;
	}

}