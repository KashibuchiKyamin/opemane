/**
 * プロジェクト一覧用js
 */

const requestSubjectData = function() {
	const tableData = {
		subjects: [
			{
				name: "samurai - STEP2.5対応",
				code: "A0123456789"
			},
			{
				name: "gate - 新規開発",
				code: "A1123456789"
			},
			{
				name: "社内業務",
				code: "G2123456789"
			},
			{
				name: "ideon - 保守対応",
				code: "A3123456789"
			}
		]
	};
	return tableData;
}

/**
 * @param subjectJson 案件情報のJSON
 * @param tableObject JSONを流し込む対象のHTMLTableElement
 */
const createTable = function(subjectJson, tableObject) {
	const subjects = subjectJson.subjects;
	let rowCount = 1;
	Object.keys(subjects).forEach(function(key) {
		const row = tableObject.insertRow(-1);
		const noCell = row.insertCell(0); // 0: No.列
		noCell.appendChild(document.createTextNode(rowCount++))
		const subjectCell = row.insertCell(1); // 1: プロジェクト名列
		subjectCell.appendChild(document.createTextNode(subjects[key].name))
		const codeCell = row.insertCell(2); // 2: コード列
		codeCell.appendChild(document.createTextNode(subjects[key].code))
	});
}