import React, { useEffect, useState } from 'react';
import { useParams,useNavigate } from 'react-router-dom'; 
import PatientService from '../../services/PatientService';

function UpdatePatient() {

  const { patientId } = useParams(); 

  const [patient, setPatient] = useState({
    patientName: '',
    email: '',
    age: '',
    mobileNumber: '',
  });

  const navigate = useNavigate();

  useEffect(() => {
    const fetchPatient = async () => {
      try {
        const fetchedPatient = await PatientService.getPatientById(patientId);
        setPatient(fetchedPatient); 
      } catch (error) {
        console.error('Error fetching patient details:', error);
      }
    };

    if (patientId) {
      fetchPatient(); 
    }
  }, [patientId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPatient((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await PatientService.updatePatient(patient);
      if(response.state=200){
        navigate('/list-patients',{
            state:{successMessage:"Patient updated successfully!"}
          });
      }
    } catch (error) {
      console.error('Error updating patient:', error);
      navigate('/list-patients',{
        state:{successMessage:"Patient updation failed. Please try again later"}
      });
    }
  };

  return (
    <div className="add-patient-container">
    <h1>Update Patient</h1>
    <form onSubmit={handleSubmit} className="patient-form">
      <div className="form-group">
        <label>Patient Name:</label>
        <input
          type="text"
          name="patientName"
          value={patient.patientName}
          onChange={handleChange}
          placeholder="Enter patient name"
          required
        />
      </div>
      <div className="form-group">
        <label>Email:</label>
        <input
          type="email"
          name="email"
          value={patient.email}
          onChange={handleChange}
          placeholder="Enter email"
          required
        />
      </div>
      <div className="form-group">
        <label>Age:</label>
        <input
          type="number"
          name="age"
          value={patient.age}
          onChange={handleChange}
          min="0"
          placeholder="Enter age"
          required
        />
      </div>
      <div className="form-group">
        <label>Mobile Number:</label>
        <input
          type="tel"
          name="mobileNumber"
          value={patient.mobileNumber}
          onChange={handleChange}
          pattern="[0-9]{10}"
          placeholder="Enter mobile number"
          required
        />
      </div>
      <button type="submit" className="submit-button">
        Update Patient
      </button>
    </form>
  </div>
  );
}

export default UpdatePatient;
