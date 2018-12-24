package priv.sell.service.auth.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import priv.sell.common.config.util.AuthUtil;

@Service
public class AuthService {
	public boolean getAuthByEntryId(String entryId) {
		if (new Random().nextBoolean()) {
			return false;
		}
		return AuthUtil.isHavingAuth(entryId);
	}
}
