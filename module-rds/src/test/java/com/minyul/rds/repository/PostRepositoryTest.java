package com.minyul.rds.repository;

import com.minyul.rds.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * stub으로만 테스트할게 아님. Dao쪽은
 * @author Minyul
 */
//@ExtendWith(MockitoExtension.class)
//class PostRepositoryTest {
//
//	@Mock
//	PostRepository postRepository;
//
//	@DisplayName("피드를 저장하고 저장한 피드를 잘 갖고오는 지 확인")
//	@Test
//	void test_save_post() {
//
//		// 전제
//		final Post post = new Post(1L, "title");
//		given(postRepository.save(post)).willReturn(post);
//
//		Post resultPost = postRepository.save(post);
//
//		verify(postRepository, times(1)).save(post);
//		Assertions.assertEquals(post.getId(), resultPost.getId(), 2L);
//	}
//}


/**
 *  DateJpaTest - 트랜잭션 있으므로 자동 롤백됨. Good
 *  By default, tests annotated with {@code @DataJpaTest} are transactional and roll back
 *  @author : Minyul
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@DisplayName("피드를 저장하고 저장한 피드를 잘 갖고오는 지 확인")
	@Test
	void test_save_post() {

		// when
		final Post post = Post.builder()
						.title("minyul")
						.build();

		// given
		final Post resultPost = postRepository.save(post);

		// then
		assertThat(post.getId()).isEqualTo(resultPost.getId());
		assertThat(post.getTitle()).isEqualTo(resultPost.getTitle());
	}
}