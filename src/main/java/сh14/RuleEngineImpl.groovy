package сh14

import org.springframework.stereotype.Component

@Component("ruleEngine")
class RuleEngineImpl implements RuleEngine {

    void run(Rule rule, Object object) {
        println "Execution rule"
        def exit=false

        rule.parameters.each {ArrayList params ->
            def paramIndex=0
            def success=true

            if (!exit){
                rule.conditions.each {
                    println "Condition Param index: " + paramIndex
                    success = success && it(object, params[paramIndex])
                    println "Condition success: " + success
                    paramIndex++
                }

                if (success && !exit){
                    rule.actions.each{
                        println "Actions Param index: " + paramIndex
                        it(object, params[paramIndex])
                        paramIndex++
                    }
                    if (rule.singlehit){
                        exit=true
                    }
                }
            }

        }
    }
}
