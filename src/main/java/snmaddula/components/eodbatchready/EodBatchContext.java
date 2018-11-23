package snmaddula.components.eodbatchready;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;

/**
 * EOD Batch spring bean and spring batch configuration.
 * 
 * @author snmaddula
 *
 */
@AllArgsConstructor
@EnableBatchProcessing
class EodBatchContext {

	private JobBuilderFactory jobs;
	private StepBuilderFactory steps;
	private DataSource dataSource;

	@Bean
	public Job eodJob(Step step) {
		return jobs.get("eodJob").start(step).build();
	}
	
	@Bean
	public Step step1(ItemReader<String> reader, 
			ItemProcessor<String, String> processor, ItemWriter<String> writer) {
		return steps.get("step1")
				.<String, String>chunk(10).reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	
}
