package com.example.toyshop.service;

import com.example.toyshop.dto.FeedCreateDTO;
import com.example.toyshop.dto.FeedListDTO;
import com.example.toyshop.entity.Feed;
import com.example.toyshop.entity.User;
import com.example.toyshop.repository.FeedRepository;
import com.example.toyshop.service.mapper.FeedMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedService {
    private final FeedRepository repository;
    private final UserService userService;
    private FeedMapper mapper;


    public FeedListDTO create(FeedCreateDTO dto) {
        User author = userService.findById(dto.getAuthorId());
        Feed feed = mapper.fromCreateDto(dto);
        feed.setAuthor(author);
        return mapper.toListDto(repository.save(feed));
    }

    public List<FeedListDTO> findAll() {
        return repository.findAll().stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public List<FeedListDTO> findAllByUserId(Long id) {
        return repository.findAllByAuthorId(id).stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public FeedListDTO findById(Long id){
        return mapper.toListDto(repository.findById(id).orElse(null));
    }

    public Feed update(Feed feed) {
        return repository.save(feed);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
