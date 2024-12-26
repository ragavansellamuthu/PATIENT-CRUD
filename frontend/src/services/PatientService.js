import axios from 'axios';

const API_URL = 'http://localhost:8080/aria/patient';

const addPatient = async (patientData) => {
  try{
    const response = await axios.post(API_URL, patientData);
    return response ; 
  } catch(error){
    console.log("Error adding patient : " + error);
    throw error ; 
  }
}

const getPatients = async () => {
  try {
    const response = await axios.get(API_URL+'/list');
    return response.data;
  } catch (error) {
    console.error("Error fetching patients :", error);
    throw error;
  }
};

const getPatientById = async (patientId) => {
    try{
        const response =  await axios.get(`${API_URL}/${patientId}`);
        return response.data;
    } catch(error){
        console.log("Error fetching patient for the ID : " + patientId);
        throw error;
    }
}

const updatePatient = async (patientData) => {
  try {
    const response = await axios.put(API_URL, patientData);
    return response;
  } catch (error) {
    console.error("Error updating patient:", error);
    throw error.response ? error.response.data : 'Update failed';
  }
};

const deletePatient = async (patientId) => {
  try {
    const response = await axios.delete(`${API_URL}/${patientId}`);
    return response;
  } catch (error) {
    console.error("Error deleting patient for ID: " +  patientId);
    throw error;
  }
};

const checkDuplicateEmail = async (email) => {
  try {
    const response = await axios.get(`${API_URL}/check-duplicate-email/${email}`);
    return response.data;
  } catch (error) {
    console.error("Error checking duplicate email:", error);
    throw error.response ? error.response.data : 'Unable to check duplicate email';
  }
};



export default {
  getPatients,getPatientById,addPatient,updatePatient,deletePatient,checkDuplicateEmail
};
