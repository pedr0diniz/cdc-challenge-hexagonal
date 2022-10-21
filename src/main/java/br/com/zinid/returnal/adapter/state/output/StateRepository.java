package br.com.zinid.returnal.adapter.state.output;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, Long> {
}
