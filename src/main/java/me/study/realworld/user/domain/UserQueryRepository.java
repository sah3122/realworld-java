package me.study.realworld.user.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.study.realworld.user.vo.Email;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

import static me.study.realworld.user.domain.QUser.user;

@Repository
public class UserQueryRepository extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryRepository(JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public boolean existsByEmail(String email) {
        User user = jpaQueryFactory.selectFrom(QUser.user)
                                   .where(QUser.user.email.eq(new Email(email)))
                                   .limit(1)
                                   .fetchOne();
        return Objects.nonNull(user);
    }

    public Optional<User> findByUsernameAndPassword(String username, String purePassword) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(user)
                                          .where(user.username.eq(username).and(user.password.eq(purePassword)))
                                          .fetchOne());
    }
}
