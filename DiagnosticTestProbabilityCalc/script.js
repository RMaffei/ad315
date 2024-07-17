function calculateProbabilities() {
	// grab input values 
	const prevalence = parseFloat(document.getElementById('prevalence').value);
	const sensitivity = parseFloat(document.getElementById('sensitivity').value);
	const specificity = parseFloat(document.getElementById('specificity').value);

	// calculate probabilties 
	const probDiseaseGivenPositive = (sensitivity * prevalence) / ((sensitivity * prevalence) + ((1 - specificity) * (1 - prevalence)));
	const probDiseaseGivenNegative = ((1 - sensitivity) * prevalence) / (((1 - sensitivity) * prevalence) + (specificity * (1 - prevalence)));

	// print results
	document.getElementById('prob-positive').innerText = `Probability of Disease given Positive Test: ${(probDiseaseGivenPositive * 100).toFixed(2)}%`;
	document.getElementById('prob-negative').innerText = `Probability of Disease given Negative Test: ${(probDiseaseGivenNegative * 100).toFixed(2)}%`;
}