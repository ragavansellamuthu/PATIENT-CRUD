import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, Link} from 'react-router-dom';
import PatientService from '../../services/PatientService';
import './ViewPatient.css'; 

function ViewPatient() {

  const navigate = useNavigate();
  const [patient, setPatient] = useState({
    patientName: '',
    email: '',
    password: '',
    age: '',
    mobileNumber: '',
  });

  const location = useLocation();
  const patientId = location.state?.patientId || 0; 

  useEffect(() => {
    const fetchPatient = async () => {
      if (patientId > 0) {
        const patientDetails = await PatientService.getPatientById(patientId);
        setPatient(s=>s=patientDetails); 
      }
    };

    fetchPatient();
  }, [patientId]); 

  // const handleBack = () => {
  //   // navigate(-1); // Not working as expected . Succes / Error message - not getting reset. 
  //   navigate('/list-patients');
  // };

  return (
    <div className="patient-details-container">
    <div className="patient-info">
      <h2>{patient.patientName}</h2>
      <p><strong>Email:</strong> {patient.email}</p>
      <p><strong>Age:</strong> {patient.age}</p>
      <p><strong>Mobile Number:</strong> {patient.mobileNumber}</p>
    </div>
    {/* <button className="back-button" onClick={handleBack}>Back</button> */}
    <Link to={'/list-patients'} style={{textDecorationLine:'none'}}>
    <button className="back-button">Back</button>
    </Link>
  </div>
  );
}

export default ViewPatient;
