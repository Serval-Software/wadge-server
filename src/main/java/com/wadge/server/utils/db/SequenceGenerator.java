package com.wadge.server.utils.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SequenceGenerator(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public long generateSequence(final String sequenceName) {
        final Criteria criteria = Criteria.where("_id").is(sequenceName);
        final Query query = new Query(criteria);
        final Update update = new Update().inc("sequence", 1);
        final FindAndModifyOptions options = FindAndModifyOptions
            .options()
            .returnNew(true)
            .upsert(true);
        final DataBaseSequence sequence =  mongoTemplate.findAndModify(
                query,
                update,
                options,
                DataBaseSequence.class);

        return sequence == null ? 1 : sequence.getSequence();
    }
}
