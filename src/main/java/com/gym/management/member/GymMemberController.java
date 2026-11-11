package com.gym.management.member;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/members")
public class GymMemberController {

    private final GymMemberRepository repository;

    public GymMemberController(GymMemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<GymMember> getAllMembers() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/{id}")
    public GymMember getMember(@PathVariable Long id) {
        return findMember(id);
    }

    @PostMapping
    public ResponseEntity<GymMember> createMember(@Valid @RequestBody GymMemberRequest request) {
        GymMember member = repository.save(new GymMember(
                request.name(), request.email(), request.phone(), request.membershipType()));
        return ResponseEntity.created(URI.create("/api/members/" + member.getId())).body(member);
    }

    @PutMapping("/{id}")
    public GymMember updateMember(@PathVariable Long id, @Valid @RequestBody GymMemberRequest request) {
        GymMember member = findMember(id);
        member.update(request.name(), request.email(), request.phone(), request.membershipType());
        return repository.save(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        repository.delete(findMember(id));
        return ResponseEntity.noContent().build();
    }

    private GymMember findMember(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Gym member not found: " + id));
    }
}
