package tech.zectrosan.xtendsearch.server.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tech.zectrosan.xtendsearch.server.entity.Document;
import tech.zectrosan.xtendsearch.server.repository.DocumentRepository;

@RestController
public class SearchController {

	@Autowired
	private DocumentRepository documentRepository;

	@AllArgsConstructor
	class IndexResponse {
		@Getter
		@Setter
		private boolean success;
		@Getter
		@Setter
		private boolean error;
		@Getter
		@Setter
		private String message;
	}

	@PostMapping("/index")
	public IndexResponse index(@RequestBody Document d) {

		this.documentRepository.save(d);

		return new IndexResponse(true, false, "OK; Id: " + d.getId());
	}

	@GetMapping("/search")
	public List<Document> search(@RequestParam("q") String query) {

		return StreamSupport
				.stream(this.documentRepository.search(new MultiMatchQueryBuilder(query, "title", "description")
						.operator(Operator.AND).type(MultiMatchQueryBuilder.Type.MOST_FIELDS)).spliterator(), false)
				.collect(Collectors.toList());

	}

}
