import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import PatientService from '../../services/PatientService';
import './AddPatient.css';

function AddPatient() {

  const [formData, setFormData] = useState({
    patientName: '',
    email: '',
    password: '',
    age: '',
    mobileNumber: '',
  });

  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await PatientService.addPatient(formData);
      if (response.status === 200) {
        navigate('/list-patients', {
          state: { successMessage: 'Patient added successfully!' },
        });
      }
    } catch (error) {
      console.error('Error:', error);
      navigate('/list-patients', {
        state: { errorMessage: 'Failed to add Patient. Please try again later' },
      });
    }
  };

  return (
    <div className="add-patient-container">
      <h1>Add Patient</h1>
      <form onSubmit={handleSubmit} className="patient-form">
        <div className="form-group">
          <label>Patient Name:</label>
          <input
            type="text"
            name="patientName"
            value={formData.patientName}
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
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email"
            required
          />
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Enter password"
            required
          />
        </div>
        <div className="form-group">
          <label>Age:</label>
          <input
            type="number"
            name="age"
            value={formData.age}
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
            value={formData.mobileNumber}
            onChange={handleChange}
            pattern="[0-9]{10}"
            placeholder="Enter mobile number"
            required
          />
        </div>
        <button type="submit" className="submit-button">
          Add Patient
        </button>
      </form>
    </div>
  );
}

export default AddPatient;
