/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.mmlab.rml.rmlvalidator;

import be.ugent.mmlab.rml.model.SubjectMap;
import be.ugent.mmlab.rml.model.TriplesMap;
import be.ugent.mmlab.rml.model.reference.ReferenceIdentifier;
import be.ugent.mmlab.rml.rml.RMLVocabulary;
import be.ugent.mmlab.rml.rml.RMLVocabulary.Term;
import be.ugent.mmlab.rml.sesame.RMLSesameDataSet;
import java.util.List;
import java.util.Map;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.Value;

/**
 *
 * @author andimou
 */
public interface RMLMappingValidator {
    RMLValidatorResult validationResult = new RMLValidatorResult();

    public void checkTriplesMapResources(Map<Resource, TriplesMap> triplesMapResources);
    public void checkSubjectMap(SubjectMap subjMap);

    /**
     *
     * @param triplesMap
     * @param statements
     * @param p
     * @param termType
     */
    public void checkEmptyStatements(TriplesMap triplesMap, List<Statement> statements, URI p, Resource resource);

    public void checkMultipleStatements(TriplesMap triplesMap, List<Statement> statements, URI p, String termType);

    public void checkTermMap(
            Value constantValue, String stringTemplate, ReferenceIdentifier referenceValue, String stringValue, Term term);

    public void checkStatements(Resource resource, List<Statement> statements, Term p);

    public RMLSesameDataSet checkIterator(
            Resource triplesMapSubject, List<Statement> iterators, RMLVocabulary.QLTerm referenceFormulation);

    public void checkSource(Resource triplesMapSubject, List<Statement> sourceStatements);

    public void checkLogicalSource(
            Resource triplesMapSubject, List<Statement> logicalSourceStatements, TriplesMap triplesMap);

    public void checkReferenceFormulation(Resource triplesMapSubject, List<Statement> statements);
}
