    package com.example.springdatabasicdemo.repositories;

    import com.example.springdatabasicdemo.dtos.AuthorDto;
    import com.example.springdatabasicdemo.models.Author;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Modifying;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;

    @Repository
    public interface AuthorRepository extends JpaRepository<Author,Integer> {
        @Transactional
        @Modifying
        @Query("SELECT a FROM Author a WHERE a.full_name = :full_name")
        List<AuthorDto> findAllByFullName(String full_name);
    }
