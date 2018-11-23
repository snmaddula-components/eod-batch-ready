package snmaddula.components.eodbatchready;

import java.lang.annotation.Retention;

import org.springframework.context.annotation.Import;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * EOD Batch enabler annotation
 * 
 * @author snmaddula
 *
 */
@Retention(RUNTIME)
@Import(EodBatchContext.class)
public @interface EodBatchReady {

}
