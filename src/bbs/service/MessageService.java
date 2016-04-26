package bbs.service;

import static bbs.utils.CloseableUtil.*;
import static bbs.utils.DBUtil.*;

import java.sql.Connection;
import java.util.List;

import bbs.beans.Message;
import bbs.beans.UserMessage;
import bbs.dao.MessageDao;
import bbs.dao.UserMessageDao;


public class MessageService {
	public void register(Message message) throws Exception{
		Connection connection = null;
		try{
			connection = getConnection();
			MessageDao messageDao = new MessageDao();

			messageDao.insert(connection, message);
			commit(connection);
		}catch(RuntimeException e){
			e.printStackTrace();
			rollback(connection);
			throw e;
		}catch(Error e){
			e.printStackTrace();
			rollback(connection);
			throw e;
		}finally{
			close(connection);
		}
	}

	public List<UserMessage> getMessage() {
		Connection connection = null;
		List<UserMessage> ret = null;
		try{
			connection = getConnection();
			UserMessageDao messageDao = new UserMessageDao();
			ret = messageDao.getUserMessages(connection);
			commit(connection);
		}catch(RuntimeException e){
			rollback(connection);
			throw e;
		}catch(Error e){
			rollback(connection);
			throw e;
		} catch (Exception e) {

		}finally{
			close(connection);
		}
		return ret;
	}

	public List<String> getCategories(){
		Connection connection = null;
		List<String> ret = null;
		try{
			connection = getConnection();
			MessageDao messageDao = new MessageDao();
			ret = messageDao.getCategories(connection);
			commit(connection);
		}catch(RuntimeException e){
			rollback(connection);
			throw e;
		}catch(Error e){
			rollback(connection);
			throw e;
		}finally{
			close(connection);
		}
	return ret;
	}

	public List<UserMessage> getMessage(String category) {
		Connection connection = null;
		List<UserMessage> ret = null;
		try{
			connection = getConnection();
			UserMessageDao messageDao = new UserMessageDao();
			ret = messageDao.getUserMessages(connection, category);
			commit(connection);
		}catch(RuntimeException e){
			rollback(connection);
			throw e;
		}catch(Error e){
			rollback(connection);
			throw e;
		} catch (Exception e) {

		}finally{
			close(connection);
		}
		return ret;
	}
}