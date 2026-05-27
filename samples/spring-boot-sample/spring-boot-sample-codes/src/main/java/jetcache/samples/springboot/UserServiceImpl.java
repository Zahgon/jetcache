/**
 * Created on 2018/8/11.
 */
package jetcache.samples.springboot;

import org.springframework.stereotype.Repository;

/**
 * @author huangli
 */
@Repository
public class UserServiceImpl implements UserService {

    @Override
    public User loadUser(long userId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
