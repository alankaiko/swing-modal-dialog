package raven.modal.demo.model.dto.extra;

import java.time.LocalDate;

public class InstanciaWorklistFilter {
	private String pacienteid; // Tag.PatientID
	private LocalDate datanasc; // Tag.PatientBirthDate
	private String pacientenome; // Tag.PatientName
	private LocalDate dataexameinicio; // Tag.ScheduledProcedureStepStartDate
	private LocalDate dataexamefim; // Tag.ScheduledProcedureStepStartDate
	private String procedimento; // Tag.ScheduledProcedureStepDescription
	private String modalidade; // Tag.Modality
	private String solicitante; // Tag.ScheduledPerformingPhysicianName
	private String localdoexame; // Tag.ScheduledProcedureStepLocation

//	(0008,0051) SQ [1 Items] IssuerOfAccessionNumberSequence
//	>Item #1
//	(0008,0090) PN [] ReferringPhysicianName
//	(0010,0021) LO [] IssuerOfPatientID
//	(0010,0040) CS [] PatientSex
//	(0010,1030) DS [] PatientWeight
//	(0010,2000) LO [] MedicalAlerts
//	(0010,2110) LO [] Allergies
//	(0010,21C0) US [] PregnancyStatus
//	(0020,000D) UI [] StudyInstanceUID
//	(0032,1032) PN [] RequestingPhysician
//	(0032,1033) LO [] RequestingService
//	(0032,1060) LO [] RequestedProcedureDescription
//	(0032,1064) SQ [1 Items] RequestedProcedureCodeSequence
//	>Item #1
//	(0038,0010) LO [] AdmissionID
//	(0038,0014) SQ [1 Items] IssuerOfAdmissionIDSequence
//	>Item #1
//	(0038,0050) LO [] SpecialNeeds
//	(0038,0300) LO [] CurrentPatientLocation
//	(0038,0500) LO [] PatientState
//	(0040,0100) SQ [1 Items] ScheduledProcedureStepSequence
//	>Item #1
//	>(0032,1070) LO [] RequestedContrastAgent
//	>(0040,0001) AE [TESTANDO PELA SIMULACAO] ScheduledStationAETitle
//	>(0040,0008) SQ [1 Items] ScheduledProtocolCodeSequence
//	>>Item #1
//	>(0040,0009) SH [] ScheduledProcedureStepID
//	>(0040,0010) SH [] ScheduledStationName
//	>(0040,0011) SH [] ScheduledProcedureStepLocation
//	>(0040,0012) LO [] PreMedication
//	>(0040,0020) CS [] ScheduledProcedureStepStatus
//	(0040,1001) SH [] RequestedProcedureID
//	(0040,1003) SH [] RequestedProcedurePriority
//	(0040,1004) LO [] PatientTransportArrangements
//	(0040,2016) LO [] PlacerOrderNumberImagingServiceRequest
//	(0040,2017) LO [] FillerOrderNumberImagingServiceRequest
//	(0040,3001) LO [] ConfidentialityConstraintOnPatientDataDescription


	public String getPacienteid() {
		return pacienteid;
	}

	public void setPacienteid(String pacienteid) {
		this.pacienteid = pacienteid;
	}

	public LocalDate getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}

	public String getPacientenome() {
		return pacientenome;
	}

	public void setPacientenome(String pacientenome) {
		this.pacientenome = pacientenome;
	}
	
	public LocalDate getDataexameinicio() {
		return dataexameinicio;
	}
	
	public void setDataexameinicio(LocalDate dataexameinicio) {
		this.dataexameinicio = dataexameinicio;
	}

	public LocalDate getDataexamefim() {
		return dataexamefim;
	}
	
	public void setDataexamefim(LocalDate dataexamefim) {
		this.dataexamefim = dataexamefim;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getLocaldoexame() {
		return localdoexame;
	}

	public void setLocaldoexame(String localdoexame) {
		this.localdoexame = localdoexame;
	}

	@Override
	public String toString() {
		return "ProcedimentoWorklistFilter [pacienteid=" + pacienteid + ", datanasc=" + datanasc + ", pacientenome="
				+ pacientenome + ", dataexameinicio=" + dataexameinicio + ", dataexamefim=" + dataexamefim
				+ ", procedimento=" + procedimento + ", modalidade=" + modalidade + ", solicitante=" + solicitante
				+ ", localdoexame=" + localdoexame + "]";
	}
	
	

}
