package readinglist;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
public class Reader implements UserDetails {

    private static final long serialVersionUIID = 1L;

    @Id
    private String username;
    private String fullname;
    private String password;

    // UserDetails methods

    // 권한 부여
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    // 계정이 만료되지 않았다는 것을 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨 있지 않았다는 것을 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자격이 유효하다는 것을 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화되어 있다는 것을 반환
    @Override
    public boolean isEnabled() {
        return true;
    }
}
