import com.abanppc.gateway.Role
import com.abanppc.gateway.User
import com.abanppc.gateway.UserRole

class BootStrap {

    def init = { servletContext ->
        def userRole = Role.findByAuthority('ROLE_USER')
        if(userRole == null) {
            userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        }
		
        def testUser = User.findByUsername('admin')
        if(testUser == null) {
            testUser = new User(username: 'admin', enabled: true, password: 'password')
            testUser.save(flush: true)
        }
		
        if(!UserRole.findByUserAndRole(testUser, userRole)) {
            UserRole.create testUser, userRole, true
        }
		
    }
    def destroy = {
    }
}
